<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <!-- datepicker-->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- my stylesheet -->
    <link rel="stylesheet" href="/static/css/style.css">
</head>

<body>
    <h1>Speak your medicine reminder</h1>
    <button onclick="startListening()">🎙 Start Speaking</button>
    <p id="transcript"></p>
    <button onclick="sendToGemini()">📤 Send to Gemini</button>

    <pre id="response"></pre>

    <script>
        let recognition;
        let transcriptText = '';

        function startListening() {
            if (!('webkitSpeechRecognition' in window)) {
                alert("Speech recognition not supported!");
                return;
            }

            recognition = new webkitSpeechRecognition();
            recognition.lang = "en-US";
            recognition.interimResults = false;
            recognition.continuous = false;

            recognition.onresult = function(event) {
                transcriptText = event.results[0][0].transcript;
                document.getElementById("transcript").innerText = transcriptText;
            };

            recognition.onerror = function(event) {
                alert("Error: " + event.error);
            };

            recognition.start();
        }

        function sendToGemini() {
            fetch('/gemini/generate', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({
                    name: "Custom from speech",
                    frequency: "based on spoken input",
                    time: "interpreted by AI",
                    prompt: transcriptText
                })
            })
                .then(response => response.text())
                .then(data => {
                    document.getElementById("response").innerText = data;
                });
        }
    </script>
</body>
</html>