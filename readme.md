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
