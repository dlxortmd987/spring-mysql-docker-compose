# spring-mysql-docker-compose
스프링 부트와 mysql 을 docker 를 이용해여 구성

## docker-compose 없이 프로젝트 구동 방법
1. 도커 허브에서 MySQL 이미지 가져오기
```shell
docker pull mysql:8
```
2. MySQL 컨테이너 구동
```shell
docker run --name testdb -p 3306:3306 --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=test -d mysql:8
```
3. Dockerfile 을 이용해 이미지 빌드
```shell
docker build . -t testapp
```
4. 빌드된 이미지로 컨테이너 구동
```shell
docker run -p 8080:8080 --name testapp --network springboot-mysql-net -d testapp
```

## docker-compose 를 통한 프로젝트 구동 방법
```shell
docker-compose up -d
```

## 테스트 방법 
- src/main/resources/test.http 파일 참조
0. 프로젝트 빌드, .jar 파일 생성 확인 (./build/libs/*.jar)
1. (GET) http://localhost:8080 호출
   -> hello 가 나오면 성공
2. (POST) http://localhost:8080/user 호출
3(GET) http://localhost:8080/1 호출
   -> json data 가 정상적으로 나오면 성공
    ```json
      {
        "id": 1,
        "name": "test"
      }
   ```