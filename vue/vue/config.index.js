module.exports = {
    publicPath:'/',
  //1.为文件配置别名
    configureWebpack:{
      resolve:{
        alias:{
          'assets':"@/assets",
          'common':"@/common",
          'components':'@/components',
          'network':'@/network',
          'views':'@/views'
        }
      },
   
    },
       //2.配置跨域
       devServer:{
        //设置代理
        proxy:{
          "/api":{
            // target用于配置你允许访问数据的计算机名称，即是你的api接口的服务器地址
            target: 'http://v.juhe.cn',
            ws:true,//启用webSocket
            changeOrigin:true,//开启代理跨域
            pathRewrite:{
              '^/api':""
            }
          }
        },
      }
  }