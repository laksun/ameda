 yum install --setopt=obsoletes=0    docker-ce-17.03.2.ce-1.el7.centos.x86_64    docker-ce-selinux-17.03.2.ce-1.el7.centos.noarch
 
systemctl start docker
docker run hello-world
docker images

yum upgrade python-setuptools
yum install python-pip python-wheel
pip install docker-compose
pip install --upgrade pip

systemctl start docker
systemctl enable docker
