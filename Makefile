FILES = SyncMain.java Producer.java Consumer.java BoundedBuffer.java
all:
	javac -g $(FILES)
run:
	java SyncMain
clean:
	rm *.class
package:
	zip -r Curcio-Jason-HW4.zip $(FILES) Makefile README.txt