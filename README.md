# Countdown Timer API 🕰️
API for the application Countdown (https://github.com/ronaldothame/countdown_timer_front).

## POST 📥
/countdown

- Receives an object and saves it in a .txt file.
Example:
```JSON
{
 "eventName": "Ronaldo's birthday",
 "eventDate": "1693785600000"
} 
```

## GET 📤
/countdown

- Creates a new ArrayList which contains each element from the .txt file and returns it.

## DELETE ❌

/countdown

- Clears all content in the .txt file.
