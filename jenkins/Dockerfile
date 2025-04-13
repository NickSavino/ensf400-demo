FROM jenkins/jenkins:lts

USER root

# Install Docker CLI in Jenkins container
RUN apt-get update && \
    apt-get install -y docker.io && \
    usermod -aG docker jenkins