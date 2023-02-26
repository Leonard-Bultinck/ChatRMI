killall rmiregistry
#ClientPush_itf  --jar 
javac -d classes -classpath .:classes src/ClientPush_itf.java
cd classes
jar cvf ../lib/ClientPush_itf.jar ClientPush_itf.class
cd ..
#ClientPushImpl  --jar
javac -d classes -classpath .:classes src/ClientPushImpl.java
cd classes
jar cvf ../lib/ClientPushImpl.jar ClientPushImpl.class
cd ..
#StringRMI_itf  --jar
javac -d classes -classpath .:classes src/StringRMI_itf.java
cd classes
jar cvf ../lib/StringRMI_itf.jar StringRMI_itf.class
cd ..
#StringImpl  --jar
javac -d classes -classpath .:classes src/StringImpl.java
cd classes
jar cvf ../lib/StringImpl.jar StringImpl.class
cd ..
#Accounting_itf  --jar
javac -d classes -classpath .:classes src/Accounting_itf.java
cd classes
jar cvf ../lib/Accounting_itf.jar Accounting_itf.class
cd ..
#Info_itf  --jar
javac -d classes -classpath .:classes src/Info_itf.java
cd classes
jar cvf ../lib/Info_itf.jar Info_itf.class
cd ..
#Registry_itf  --jar
javac -d classes -classpath .:classes src/Registry_itf.java
cd classes
jar cvf ../lib/Registry_itf.jar Registry_itf.class
cd ..
#RegistryImpl  --jar
javac -d classes -classpath .:classes src/RegistryImpl.java
cd classes
jar cvf ../lib/RegistryImpl.jar RegistryImpl.class
cd ..
#Hello interface  --jar
javac -d classes -classpath .:classes src/Hello.java
cd classes
jar cvf ../lib/Hello.jar Hello.class
cd ..
#HelloImpl  --jar
javac -d classes -classpath .:classes src/HelloImpl.java
cd classes
jar cvf ../lib/HelloImpl.jar HelloImpl.class
cd ..
#Hello2_itf  --jar
javac -d classes -classpath .:classes src/Hello2.java
cd classes
jar cvf ../lib/Hello2.jar Hello2.class
cd ..
#Hello2Impl  --jar
javac -d classes -classpath .:classes src/Hello2Impl.java
cd classes
jar cvf ../lib/Hello2Impl.jar Hello2Impl.class
cd ..
#ClientImpl  --jar
javac -d classes -classpath .:classes src/ClientImpl.java
cd classes
jar cvf ../lib/ClientImpl.jar ClientImpl.class
cd ..



#HelloClient 
javac -d classes -cp .:classes:lib/Hello.jar:lib/Info_itf.jar:lib/ClientImpl.jar:lib/Hello2.jar:lib/Accounting_itf.jar:lib/Registry_itf.jar:lib/RegistryImpl.jar:lib/StringRMI_itf.jar:StringImpl.jar:lib/ClientPush_itf.jar:lib/ClientPushImpl.jar src/HelloClient.java
#HelloServer 
javac -d classes -cp .:classes:lib/Hello.jar:lib/HelloImpl.jar:lib/Info_itf.jar:lib/HelloClient.jar:lib/ClientImpl.jar:lib/Hello2.jar:lib/Accounting_itf.jar:lib/Registry_itf.jar:lib/Hello2Impl.jar:lib/RegistryImpl.jar:lib/StringRMI_itf.jar::lib/ClientPush_itf.jar src/HelloServer.java


#Setup
killall rmiregistry
export CLASSPATH=/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/Hello.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/Info_itf.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/Hello2.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/Accounting_itf.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/Registry_itf.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/StringRMI_itf.jar:/home/leonard/Cours/M1/IDS/Tuto_rmi/lib/ClientPush_itf.jar
rmiregistry &

