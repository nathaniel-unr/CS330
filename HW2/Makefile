.PHONY: build run clean fmt uml all pkg

NAME := HW2
DRIVER := Main
JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(JAVA_FILES:.java=.class)

JAVAC := javac
JAVA := java
JAVAC_FLAGS := -Xlint:unchecked

PKG_NAME := $(NAME).zip

build: $(CLASS_FILES)
%.class : %.java
	$(JAVAC) $< $(JAVAC_FLAGS)

run: build
	$(JAVA) $(DRIVER)
	
clean:
	rm -f *.class uml.png $(PKG_NAME)

fmt:
	google-java-format -i *.java
	
uml.png: uml.plantuml
	plantuml uml.plantuml
uml: uml.png

pkg:
	zip -r $(PKG_NAME) $(JAVA_FILES)

all: build uml
