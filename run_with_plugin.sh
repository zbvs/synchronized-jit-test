rm -rf ./out/*
/usr/lib/jvm/java-8-openjdk-amd64/bin/javac -d ./out $(find ./ -name "*.java")
/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*JITTest.*' -cp ./out/ com.jittest.Main

#rm -rf ./out/*
#/usr/lib/jvm/java-11-copy/bin/javac -d ./out $(find ./ -name "*.java")
#/usr/lib/jvm/java-11-copy/bin/java -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*JITTest.*' -cp ./out/ com.jittest.Main