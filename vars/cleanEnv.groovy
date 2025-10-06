def call(Map cfg = [:]) {
  def name = cfg.name ?: error('cleanEnv: name is required')
  sh """
    set -eux
    docker rm -f ${name} || true
  """
}
