#### Run the service as a container

```shell
# build the image
$ ./gradlew bootBuildImage

# run the container
$ docker run -rm catalog-service -p 8080:8080 catalog-service:0.0.1-SNAPSHOT
```

#### Start a new local Kubernetes cluster using docker

```shell
$ minikube start --driver=docker
### OR
$ minikube start

# Make docker the default driver for minikube
$ minikube config set driver docker

# Stop
$ minikube stop
```

#### Deploy the service to the local Kubernetes cluster

```shell
# import the local image into local kubernetes cluster
$ minikube image load catalog-service:0.0.1-SNAPSHOT

# create a Deployment from a container image. Kubernetes will take care of creating Pods for the application
$ kubectl create deployment catalog-service --image=catalog-service:0.0.1-SNAPSHOT

# Verify the creation of the deployment
$ kubectl get deployment

# Verify the creation of the pod
$ kubectl get pod

# Expose Catalog Service to the cluster
$ kubectl expose deployment catalog-service --name catalog-service --port=8080

# Verify the Service Object
$ kubectl get service catalog-service

# Port forward the service to your local machine; termiate the command with Ctrl+C
$ kubectl port-forward service/catalog-service 8000:8080

# Delete the service
$ kubectl delete service catalog-service

# Delete the deployment
$ kubectl delete deployment catalog-service
```

#### Run the service locally

```shell
# package the application as a jar file
$ ./gradlew bootJar

# run the application
$ java -jar build/libs/catalog-service-0.0.1-SNAPSHOT.jar

# Run the application
$ ./gradlew bootRun
```

