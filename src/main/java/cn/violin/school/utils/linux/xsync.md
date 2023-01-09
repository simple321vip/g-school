##### xsync
[xsync同步脚本](https://zhuanlan.zhihu.com/p/377557611)<br />

###### 所有的服务器都需要安装 rxync
    yum -y install rsync
###### 在master分发服务器上创建 xsync 脚本
    /usr/local/bin
    touch xsync
    chmod 777 xsync
    vi xsync
    进入到vi编辑模式下：把下面脚本复制粘贴，注意需要修改 主机名1，不包括自己。至于hostname和主机名怎么设置应该都知道了把
        #!/bin/bash
        #1. 判断参数个数
        if [ $# -lt 1 ]
        then
          echo Not Enough Arguement!
          exit;
        fi
        #2. 遍历集群所有机器
        for host in 主机名1 主机名2 主机名3
        do
          echo ====================  $host  ====================
          #3. 遍历所有目录，挨个发送
          for file in $@
          do
            #4 判断文件是否存在
            if [ -e $file ]
            then
              #5. 获取父目录
              pdir=$(cd -P $(dirname $file); pwd)
              #6. 获取当前文件的名称
              fname=$(basename $file)
              ssh $host "mkdir -p $pdir"
              rsync -av $pdir/$fname $host:$pdir
            else
              echo $file does not exists!
            fi
          done
        done
##### 创建ssh 免密登录。
    在master 机器 生成 密匙
    ssh-keygen -t rsa
    然后 分发认证keys、也包括自己哦
    ssh-copy-id -i ~/.ssh/id_rsa.pub root@192.168.235.22
    在分发的机器上~/.ssh/路径下生成
    authorized_key
    
