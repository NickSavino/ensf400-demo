## Steps to Run:

This only works in a Git Bash or other Unix-like environment or terminal.


Option 1: Build and Run Locally
If you prefer to build the image on your machine

```sh
docker build -t <YourDockerHubUsername>/ensf400-demo:$(git rev-parse --short HEAD)
docker run -p 8080:8080 <YourDockerHubUsername>/ensf400-demo:$(git rev-parse --short HEAD)
```

Option 2: Pull and Run the Pre-Built Image
If you want to use the pre-built image from the shared Docker Hub repository:

```sh
docker pull zahmed2/ensf400-demo:145fbb6
docker run -p 8080:8080 zahmed2/ensf400-demo:145fbb6
```

For Mac Users
If you’re using an Apple Silicon Mac (M1) and encounter an architecture compatibility error, add the --platform linux/amd64 flag:

```sh
docker pull --platform linux/amd64 zahmed2/ensf400-demo:145fbb6
docker run --platform linux/amd64 -p 8080:8080 zahmed2/ensf400-demo:145fbb6
```

Once the app is running, open http://localhost:8080 in browser