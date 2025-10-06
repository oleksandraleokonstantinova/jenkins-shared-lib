def call(String dockerfile = 'Dockerfile') {
  sh """
    set -eux
    docker run --rm -i hadolint/hadolint < ${dockerfile}
  """
}
