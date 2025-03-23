# Facts API

The **Facts API** provides random facts or facts from various categories. You can retrieve facts related to animals, history, science, space, technology, or even a random fact from any category.

## Getting Started

Follow these simple steps to start using the Facts API:

### 1. Generate API Key
Before making any API requests, you'll need to generate your **API Key**. This key will be used to authenticate your requests.

### 2. Make API Requests

You can retrieve facts using simple `curl` commands.

#### Request Structure:
curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=random"  
Replace `YOUR_API_KEY` with the API key you generated.

#### Available Categories:
- `animals` - Get random animal facts
- `history` - Get random historical facts
- `science` - Get random science facts
- `space` - Get random space facts
- `technology` - Get random technology facts
- `random` - Get a random fact from any category

### 3. Example Requests

- **Get a random fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=random"`

- **Get a random animal fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=animals"`

- **Get a random historical fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=history"`

- **Get a random science fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=science"`

- **Get a random space fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=space"`

- **Get a random technology fact**:  
  `curl -H "Authorization: YOUR_API_KEY" "http://localhost:8080/api/fact?type=technology"`

### 4. Response Structure

Each response will contain a fact related to the requested category. The format will be in JSON, for example:

{ "fact": "A group of flamingos is called a 'flamboyance'." }

### 5. Troubleshooting

If you receive an error, check the following:
- Ensure your **API Key** is correct.
- Ensure you are using the correct endpoint and query parameters.
- If you are still facing issues, please contact me on discord (username: `@emn4tor.` (with the .)).
---

## Conclusion

You can now use the Facts API to get facts from various categories or a random fact. Customize your requests by specifying the category of fact you want to receive.
