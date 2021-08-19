#!/bin/bash

echo 'drop database venidemary; create database venidemary' | mysql -uroot -h192.168.1.112 --password=hp2020
cat venidemary.sql | mysql -uroot -h192.168.1.112 --password=hp2020 venidemary
cat builtin-data.sql | mysql -uroot -h192.168.1.112 --password=hp2020 venidemary

