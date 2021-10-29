

variable "bucket_name" {
  description = "Value of the bucket"
  type        = string
  default     = "my-test-bucket-kayman358"
}


variable "bucket_tag" {
  description = "Value of the Name tag for the s3 bucket"
  type        = string
  default     = "Helm"
}