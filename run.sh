/usr/lib/jvm/java-8-openjdk-amd64/bin/javac -d ./out $(find ./ -name "*.java")
/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java -XX:CompileThreshold=10 -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*JITTest.*' -cp ./out/ com.jittest.Main