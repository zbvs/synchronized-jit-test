javac -d ./out $(find ./ -name "*.java")
java -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,*JITTest.*' -cp ./out/ com.jittest.Main