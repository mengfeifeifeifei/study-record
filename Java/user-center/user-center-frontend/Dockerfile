FROM nginx

WORKDIR /app-backend

copy ./docker/nginx.conf /etc/nginx/conf.d/default.conf

run yarn build

copy ./dist /usr/share/nginx/html/

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
