def call(String image) {
  // If your network blocks DB download, add:  --skip-update
  sh """
    set -eux
    docker run --rm \
      -v /var/run/docker.sock:/var/run/docker.sock \
      aquasec/trivy:latest image \
      --severity HIGH,CRITICAL \
      --exit-code 1 \
      --no-progress \
      ${image}
  """
}
