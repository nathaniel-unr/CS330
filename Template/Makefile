# Put your project name here.
NAME := Template
# Put your driver name here.
DRIVER := Main

JAVAC := javac
JAVA := java
JAVAC_FLAGS := -Xlint:unchecked

PLANTUML := plantuml

UML_NAME := uml.plantuml

JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(JAVA_FILES:.java=.class)
PKG_NAME := $(NAME).zip

.PHONY: build run clean fmt uml all pkg

build: $(CLASS_FILES)
%.class : %.java
	$(JAVAC) $< $(JAVAC_FLAGS)

run: build
	$(JAVA) $(DRIVER)
	
clean:
	rm -f *.class uml.png $(PKG_NAME)

fmt:
	google-java-format -i *.java
	
uml.png: $(UML_NAME)
	$(PLANTUML) $(UML_NAME)
uml: uml.png

pkg:
	zip -r $(PKG_NAME) $(JAVA_FILES)

all: build uml
