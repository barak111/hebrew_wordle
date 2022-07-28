commands:
- add_game -                         curl -d "word=banana" -X POST http://localhost:8080/new_game
                                     curl -X POST http://localhost:8080/new_game\?word\=batata

- get num of letters of new  -       curl http://localhost:8080/new_game/c843db53-1df9-426b-9024-6bd19e6beb89

- get guess result -                 curl http://localhost:8080/game/c843db53-1df9-426b-9024-6bd19e6beb89\?word\=bakask
