# micronsul
Basically: my [OnTheBuses](https://github.com/kontza/on_the_buses) app converted to a Micronaut application.

# How to Run

1. Install Consul & start it:

    ```sh
    $ consul agent --dev
    ```

2. Start the first instance of this app:

    ```sh
    $ MICRONAUT_SERVER_PORT=8110 mvn spring-boot:run
    Start the second instance of this app:
    ```

3. Start the second instance of this app:

    ```sh
    $ MICRONAUT_SERVER_PORT=8111 mvn spring-boot:run
    ```

4. Trigger a message sending:

    ```bash
    $ http 'http://localhost:8110/notify?message=trial_of_the_grasses'
    ```
