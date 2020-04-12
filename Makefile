SHELL := /bin/bash

cassandra_shared_container_name := flirt-cassandra-seed-node
rabbitmq_shared_container_name := flirt-rabbitmq

#
# User rules
#
bash-cassandra: cassandra_shared_container_name$(cassandra_shared_container_name) ## Opens a shell for the Cassandra container

bash-rabbitmq: .bash-$(rabbitmq_shared_container_name) ## Opens a shell for the Cassandra containe

destroy: destroy-cassandra destroy-rabbitmq ## Destroys all the containers

destroy-cassandra: cassandra_shared_container_name$(cassandra_shared_container_name) ## Destroys cassandra container

destroy-rabbitmq: .destroy-$(rabbitmq_shared_container_name) ## Destroys cassandra container

help: ## Displays this help
	@echo 'Usage: make [target] ...'
	@echo
	@echo 'targets:'
	@echo -e "$$(grep -hE '^\S+:.*##' $(MAKEFILE_LIST) | sed -e 's/:.*##\s*/:/' -e 's/^\(.\+\):\(.*\)/\\x1b[36m\1\\x1b[m:\2/' | column -c2 -t -s :)"

restart: restart-cassandra ## Restarts all the containers

restart-cassandra: destroy-cassandra run-database ## Restarts Cassandra container

restart-rabbitmq: destroy-rabbitmq run-rabbitmq ## Restarts RabbitMQ container

run: create-network run-database run-rabbitmq ## Starts all required containers

run-database: run-database-base ## Starts a Cassandra container

run-rabbitmq: run-rabbitmq-base ## Starts a Cassandra container

run-database-base:
	@docker-compose -f docker/cassandra-cluster.yml up -d

run-rabbitmq-base:
	@docker-compose -f docker/rabbitmq.yml up -d

status: ## Shows the application containers status
	@docker ps -s

#
# Admin rules
#

create-network:
	@docker network create flirt-net 2> /dev/null || true

#
# Pattern rules
#

.bash-%:
	@docker exec -it $* bash


.destroy-%:
	@docker kill $* 2> /dev/null || true
	@docker rm $* 2> /dev/null || true

.DEFAULT_GOAL := help
