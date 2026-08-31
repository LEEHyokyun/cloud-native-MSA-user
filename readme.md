**자세한 내용은 벨로그를 통해 자세히 기술 :**
- [MSA 시리즈 #1](https://velog.io/@gyrbs22/Part1-%EC%A2%85%EB%A3%8C-%ED%9B%84-%EC%9E%91%EC%84%B1%EC%98%88%EC%A0%95-%EB%B0%B1%EC%97%94%EB%93%9C-Road-to-MSA-1-Spring-Cloud-Framework%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EB%B6%84%EC%82%B0-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EA%B5%AC%EC%B6%95-%EB%B0%A9%EC%95%88-End-to-End%EC%86%8C%EA%B7%9C%EB%AA%A8-%EC%A0%9C%ED%95%9C%EC%A0%81-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C-K8S-%EC%A0%81%EC%9A%A9-%EB%B6%88%EA%B0%80-%EC%8B%9C-%EC%B0%A8%EC%84%A0%EC%B1%85)
- [MSA 시리즈 #2](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-to-MSA-2-%EB%B6%84%EC%82%B0-%ED%99%98%EA%B2%BD%EC%97%90%EC%84%9C%EC%9D%98-%EB%B6%84%EC%82%B0-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B5%AC%EC%84%B1-%EB%B0%A9%EC%95%88)
- [MSA 시리즈 #3](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-%EB%B6%84%EC%82%B0-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-Trouble-ShootingCircuit-Breaker-%EB%B0%8F-MSA-%EC%84%9C%EB%B2%84-%EB%B3%84-%EB%B6%84%EC%82%B0%EC%B6%94%EC%A0%81%EB%AA%A8%EB%8B%88%ED%84%B0%EB%A7%81-%ED%99%98%EA%B2%BD-%EA%B5%AC%EC%84%B1-%EB%B0%A9%EC%95%88)
- [MSA 시리즈 #4](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-To-MSA-4-CICD-pipeline-%EA%B5%AC%EC%B6%95-%EB%B0%A9%EC%95%88)
- [MSA 시리즈 #5](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-To-MSA-5-Distributed-Environment%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0%EC%8B%A4%EB%AC%B4%EC%97%90%EC%84%9C-%EB%B6%84%EC%82%B0%ED%99%98%EA%B2%BD%EC%9D%84-%EA%B5%AC%EC%B6%95%ED%95%98%EA%B8%B0-%EC%9C%84%ED%95%9C-%EC%84%A4%EA%B3%84%EC%A0%81-%EA%B4%80%EC%A0%90)
- [MSA 시리즈 #6](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-To-MSA-6-%EB%B6%84%EC%82%B0-%ED%99%98%EA%B2%BD-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98%EC%97%90-%EB%8C%80%ED%95%9C-%EA%B3%A0%EC%B0%B0%EB%B6%84%EC%82%B0-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98%EC%9D%84-%EA%B5%AC%EC%84%B1%ED%95%98%EA%B8%B0-%EC%9C%84%ED%95%9C-%EC%84%A4%EA%B3%84%EC%A0%81-%EA%B4%80%EC%A0%90)
- [MSA 시리즈 #7](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-To-MSA-7-Kafka-Patterns-%EB%B6%84%EC%82%B0-%EC%8B%9C%EC%8A%A4%ED%85%9C%EC%9D%98-%EB%A9%94%EC%8B%9C%EC%A7%95-%EC%B2%98%EB%A6%AC-%EC%8B%A4%ED%8C%A8-%EC%83%81%ED%99%A9%EC%97%90-%EB%8C%80%ED%95%9C-Trouble-ShootingsDLTRetryOutbox-%EB%B0%8F-%EB%A9%B1%EB%93%B1%EC%84%B1-%EB%B3%B4%EC%9E%A5-%EC%A0%84%EB%9E%B5)
- [MSA 시리즈 #8](https://velog.io/@gyrbs22/%EB%B0%B1%EC%97%94%EB%93%9C-Road-To-MSA-8-Kafka-Patterns-%EB%B6%84%EC%82%B0-%EC%8B%9C%EC%8A%A4%ED%85%9C%EC%9D%98-%EB%A9%94%EC%8B%9C%EC%A7%95-%EC%B2%98%EB%A6%AC-%EC%8B%A4%ED%8C%A8-%EC%83%81%ED%99%A9%EC%97%90-%EB%8C%80%ED%95%9C-Trouble-ShootingsOutbox-%EB%B0%8F-%EB%A9%B1%EB%93%B1%EC%84%B1-%EB%B3%B4%EC%9E%A5-%EC%A0%84%EB%9E%B5)

## 1. Project 개요

본 Trouble Shootings은 대규모 트래픽을 도메인 분리 및 분산 환경 구성을 통해 구조적 개선 및 성능 개선을 확보할 수 있는 요건을 살펴본다.

- 기존 구성한 Order 도메인(Monolithic)의 트래픽이 집중되어, 단일 규모의 상태 및 데이터 관리가 어려울때 어떤 설계를 적용할 수 있는가?
- 분산 환경을 활용하여 비동기 메시징 체계에서의 트랜잭션 정합성을 유지하기 위한 방안은 무엇이 있을까?

도매인을 분리하여 트래픽을 분리하고, 실제 MSA 구동 환경을 가정하여 서비스를 운영하기 위해 각 마이크로서비스의 설계 방안을 살펴본다.<br/>
현재 구성한 프로젝트의 중요 요소(Order/Product 도메인의 분리 운영/비동기 메시징 체계로 이어지는 SAGA Pattern/Kafka 모듈을 OCP 기반에 근거하여 아키텍칭하는 방안)에 대해 하기와 같이 간략히 정리한다.

## 2. MicroService - User Service

중앙 유레카 서버에 User 마이크로 서비스를 등록하기 위한 목적의 프로젝트이다.

## 3. 통신환경

| Docker Service  | Spring `application.name` (Container Name) | Host Port | Container Port | 비고                   |
| --------------- | ------------------------------------------ | --------- | -------------- | -------------------- |
| eureka          | eureka                                     | 8761      | 8761           | Service Registry     |
| config-server   | config-server                              | 8888      | 8888           | Config Server        |
| gateway         | gateway                                    | 8000      | 8000           | API Gateway          |
| user-service    | user-service                               | 60000     | 60000          | User 서비스             |
| order-service-1 | order-service                              | 60010     | 60010          | Order 인스턴스 1         |
| order-service-2 | order-service                              | 60011     | 60011          | Order 인스턴스 2 (RR 대상) |
| product-service | product-service                            | 60002     | 60002          | Product 서비스          |
| kafka           | kafka                                      | 9092      | 9092           | Kafka Broker         |
| rabbitmq        | rabbitmq                                   | 5672      | 5672           | AMQP 메시지 브로커         |
| mysql-user      | mysql-user                                 | 3306      | 3306           | User DB              |
| mysql-order     | mysql-order                                | 3307      | 3306           | Order DB             |
| mysql-product   | mysql-product                              | 3308      | 3306           | Product DB           |
