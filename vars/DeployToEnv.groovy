def call(Map args = [:]) {
  def envName = args.env ?: 'main'
  def image   = args.image
  def port    = args.port ?: '3000'
  def name    = (envName == 'main') ? 'node-main' : 'node-dev'

  sh """
    set -eux
    docker rm -f ${name} || true
    docker pull ${image}
    docker run -d --name ${name} --restart unless-stopped \
      -p ${port}:3000 -e PORT=3000 -e HOST=0.0.0.0 ${image}
  """
}
