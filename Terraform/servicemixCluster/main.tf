provider "aws" {
  region = "eu-west-1"
}

##create 3 servicemix instance in subnet subnet-9a651bd3
## the same subnet with the db 10.10.3.177 td-dev-mra-db1


resource "aws_spot_instance_request" "td-cluster-smx1" {

  ami = "ami-3bfab942"
  instance_type = "m5.large"
  availability_zone = "eu-west-1b"
  spot_price = "0.04"
  tags {
    Name = "td-dev-cluster-smx1"
    AutoOff = "True"
    AutoOn  = "False"
    Cluster = "True"
    Release = "True"
  }
  key_name = "tbukaws_linux_key"
  #launch-wizard-5
  security_groups = ["sg-a6ff1fde"]

  subnet_id = "subnet-9a651bd3"
  associate_public_ip_address = true
  private_ip = "10.10.3.120"

  block_device {
    device_name = "/dev/sda1"
    volume_type = "gp2"
    volume_size = "20"
  }
}

#resource "aws_spot_instance_request" "" {
#  ami = ""
#  instance_type = ""
#  spot_price = ""
#}