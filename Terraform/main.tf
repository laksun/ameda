provider "aws" {

  region = "eu-west-1"
}

#user data

data "template_file" "user_data" {


  template = "${file("${path.module}/user_data.sh")}"
}




#key pair
resource "aws_key_pair" "deployer" {
  public_key = "${file(var.public_key_path)}"
  key_name = "deployer-key"
}


resource "aws_instance" "kubernetes1" {
  instance_type = "${var.dev_instance_type}"
  availability_zone = "eu-west-1b"
  ami = "${var.dev_ami}"
  tags {
    Name = "td-mra-cluster1"
    AutoOff = "True"
    AutoOn = "False"
    Cluster ="True"
  }

  key_name = "${aws_key_pair.deployer.id}"
  security_groups = ["sg-7c50b004","sg-7c50b004"]

  subnet_id = "subnet-9a651bd3"
  associate_public_ip_address = true
  source_dest_check = false

  user_data = "${data.template_file.user_data.rendered}"
}

##
resource "aws_instance" "kubernetes2" {
  instance_type = "${var.dev_instance_type}"
  availability_zone = "eu-west-1b"
  ami = "${var.dev_ami}"
  tags {
    Name = "td-mra-cluster2"
    AutoOff = "True"
    AutoOn = "False"
    Cluster ="True"
  }

  key_name = "${aws_key_pair.deployer.id}"
  security_groups = ["sg-7c50b004","sg-7c50b004"]

  subnet_id = "subnet-9a651bd3"
  associate_public_ip_address = true
  source_dest_check = false
  user_data = "${data.template_file.user_data.rendered}"
}


resource "aws_instance" "kubernetes3"  {
  instance_type = "${var.dev_instance_type}"
  availability_zone = "eu-west-1b"
  ami = "${var.dev_ami}"
  tags {
    Name = "td-mra-cluster3"
    AutoOff = "True"
    AutoOn = "False"
    Cluster ="True"
  }

  key_name = "${aws_key_pair.deployer.id}"
  security_groups = ["sg-7c50b004","sg-7c50b004"]

  subnet_id = "subnet-9a651bd3"
  associate_public_ip_address = true
  source_dest_check = false
  user_data = "${data.template_file.user_data.rendered}"
}