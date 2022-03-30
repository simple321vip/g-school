##### Linux中环境变量的搭建
    cd /etc/profile.d
    touch my_env.sh
    vi my_env.sh
        
        #JAVA_HOME
        export JAVA_HOME=/opt/module/jdk1.8.0_212
        export PATH=$PATH:$JAVA_HOME/bin
    source /etc/profile
##### linux中修改hostname
    vi /etc/hosts
    
