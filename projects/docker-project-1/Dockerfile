# 기본 이미지 설정
FROM nginx:latest

# index.html 파일 복사
# 오타 수정 shar -> share
COPY index.html /usr/share/nginx/html/

# Nginx 실행
CMD ["nginx", "-g", "daemon off;"]
