======

This package includes the following files.

|-- SyncMain.java [Creates shared bounded buffer and producer/consumer threads. Waits for their completion]
|-- Producer.java [Produces 1,000,000 random elements and adds to shared bounded buffer object]
|-- Consumer.java [Consumes 1,000,000 random elements and adds to running total]
|-- BoundedBuffer.java [Defines a synchronized circular bounded buffer of a specified capacity]
|-- Makefile [Make file which includes a make for SyncMain.java Producer.java Consumer.java BoundedBuffer.java and a clean]
|-- README.txt [This file]

To compile:
    make all