import sys
import time

import redis


# 根据发布时间排序文章的有序集合   根据评分排序文章的有序集合        每篇文章已投票的用户集合
#   time:        zset          score:        zset         voted:100408        set
# article:1   17746372284     acticle:1     100             user:1
# article:2   34342456443     acticle:2     99              user:2
# article:3   34532423233     acticle:3     98              user:3


# 投票功能
def article_vote(conn, user, article):
    # 检查是否还可以对文章投票
    # 时间超过一周是不允许再投票
    cutoff = time.time() - ONE_WEEK_IN_SECONDS
    # Redis Zscore 命令返回有序集中，成员的分数值。 如果成员元素不是有序集 key 的成员，或 key 不存在，返回 nil
    # 查找有序集合中'times:'下的键为article的分数值
    if conn.zscore('times:', article) < cutoff:
        return
    article_id = article.partition(':')[-1]
    # 如果用户已经投票了 就不允许再次投票
    if conn.sadd('voted:' + article_id, user):
        conn.zincrby('score:', article, VOTE_SCORE)
        conn.hincrby(article, 'votes', 1)


# 添加文章
def post_article(conn, user, title, link, article_id):
    # article_id = str(conn.incr('acticle:'))

    voted = 'voted:' + article_id
    conn.sadd(voted, user)
    conn.expire(voted, ONE_WEEK_IN_SECONDS)

    now = time.time()
    article = 'article:' + article_id
    conn.hset(article, mapping={
        'title': title,
        'link': link,
        'poster': user,
        'time': now,
        'votes': 1
    })
    conn.zadd('time:', article, now)
    conn.zadd('score:', article, now + VOTE_SCORE)

    return article_id


# 初始化文章的各个内容
def article_initial(conn):
    article_id = str(conn.incr('article:id'))
    article_title = 'title_' + article_id
    user_id = 'user:' + article_id
    link = 'link_' + article_id

    return article_id, article_title, user_id, link


redis_conn = redis.Redis(host='60.205.216.24', port=6379, password='redis_master')
article_id, title, user, link = article_initial(redis_conn)

ONE_WEEK_IN_SECONDS = 7 * 86400
VOTE_SCORE = 432
post_article(redis_conn, user, title, link, article_id)
# article_vote(redis_conn, user, article)
