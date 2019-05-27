.EXPORT_ALL_VARIABLES:

VERSION := $(shell cat ../version.txt)
KRAKEN_HOST_DATA := $(PWD)/applications/data
KRAKEN_DATA := $(PWD)/applications/data
KRAKEN_HOST_UID := $(shell id -u)
KRAKEN_HOST_GID := $(shell id -g)
KRAKEN_VERSION := $(VERSION)

clean-all:
	./gradlew clean

test-all:
	./gradlew jacocoRootReport

check: test-all
	./gradlew check --warning-mode=all

scan:
	./gradlew build --scan

# Runs tests continuously for a project
# Example: make test APP=:commons:docker-client
test:
	./gradlew $(APP):test --continuous

# Runs a Spring boot application (add --info in case of error)
# Example: make serve APP=:applications:analysis
serve:
	./gradlew $(APP):bootRun

copy-data:
	rm -rf applications/data
	cp -a applications/storage/defaultData/. applications/data/

serve-analysis:
	$(MAKE) serve APP=:applications:analysis

serve-executor:
	$(MAKE) serve APP=:applications:executor

serve-storage:
	$(MAKE) serve APP=:applications:storage

serve-static:
	docker run --rm --name kraken-static-dev -v $(KRAKEN_HOST_DATA):/usr/share/nginx/html:ro -p 8082:80 octoperf/kraken-static

clean:
	./gradlew $(APP):clean

# Creates a Spring boot application jar
# Example: make build APP=:applications:analysis
bootJar:
	./gradlew $(APP):bootJar

echo:
	@echo $(VERSION)