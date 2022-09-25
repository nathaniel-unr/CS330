# Put your project name here.
NAME := Template
# Put your driver name here.
DRIVER := Main

JAVAC := javac
JAVA := java
JAVAC_FLAGS := -Xlint:unchecked 

UML_FILE := uml.puml
UML_IMAGE_FILE := $(UML_FILE:.puml=.png)

JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(JAVA_FILES:.java=.class)
PKG_NAME := $(NAME).zip

TARGET_FILES := $(CLASS_FILES) $(UML_IMAGE_FILE) $(PKG_NAME)

.PHONY: build run clean fmt uml all pkg

build: $(CLASS_FILES)
%.class : %.java
	$(JAVAC) $< $(JAVAC_FLAGS)

run: build
	$(JAVA) $(DRIVER)
	
clean:
	rm -f $(TARGET_FILES)

fmt:
	google-java-format -i *.java
	
$(UML_IMAGE_FILE): $(UML_FILE)
	plantuml $(UML_FILE)
uml: $(UML_IMAGE_FILE)

pkg:
	zip -r $(PKG_NAME) $(JAVA_FILES)

all: build uml
