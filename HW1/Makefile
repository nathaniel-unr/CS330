.PHONY: build run clean fmt uml all

DRIVER := Main
JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(JAVA_FILES:.java=.class)

build: $(CLASS_FILES)
%.class : %.java
	javac $<

run: build
	java $(DRIVER)
	
clean:
	rm -f *.class diagram.png

fmt:
	google-java-format -i *.java
	
diagram.png: diagram.uml
	plantuml diagram.uml
uml: diagram.png

all: build uml