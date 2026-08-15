<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="{{ csrf_token() }}"> {{-- Penting untuk AJAX POST --}}
    <title>Chat dengan Gemini AI</title>
    <style>
        body { font-family: sans-serif; margin: 20px; background-color: #f4f4f4; }
        #chatbox { height: 400px; overflow-y: scroll; border: 1px solid #ccc; padding: 10px; margin-bottom: 10px; background-color: #fff; border-radius: 5px; }
        .message { margin-bottom: 10px; padding: 8px 12px; border-radius: 15px; max-width: 70%; word-wrap: break-word; }
        .user-message { background-color: #dcf8c6; align-self: flex-end; margin-left: auto; text-align: right; }
        .bot-message { background-color: #e0e0e0; align-self: flex-start; margin-right: auto; }
        #chat-form { display: flex; }
        #message-input { flex-grow: 1; padding: 10px; border: 1px solid #ccc; border-radius: 5px 0 0 5px; }
        #send-button { padding: 10px 15px; border: none; background-color: #007bff; color: white; cursor: pointer; border-radius: 0 5px 5px 0; }
        #send-button:disabled { background-color: #aaa; }
        .loading-indicator { text-align: center; color: #888; margin-top: 10px; display: none; }
    </style>
</head>
<body>

    <h1>Chat dengan API Gemini AI</h1>

    <div id="chatbox">
        {{-- Pesan chat akan muncul di sini --}}
        <div class="message bot-message">Halo! Ada yang bisa saya bantu?</div>
    </div>

    <form id="chat-form">
        @csrf {{-- Token CSRF Laravel --}}
        <input type="text" id="message-input" placeholder="Ketik pesan Anda..." autocomplete="off">
        <button type="submit" id="send-button">Kirim</button>
    </form>

    <div id="loading" class="loading-indicator">Memproses...</div>
    <div id="error-message" style="color: red; margin-top: 10px;"></div>

    <script>
        const chatbox = document.getElementById('chatbox');
        const chatForm = document.getElementById('chat-form');
        const messageInput = document.getElementById('message-input');
        const sendButton = document.getElementById('send-button');
        const loadingIndicator = document.getElementById('loading');
        const errorMessageDiv = document.getElementById('error-message');
        const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content'); // Ambil CSRF token

        // Fungsi untuk menambahkan pesan ke chatbox
        function addMessage(message, sender) {
            const messageElement = document.createElement('div');
            messageElement.classList.add('message');
            messageElement.classList.add(sender === 'user' ? 'user-message' : 'bot-message');
            // Ganti newline (\n) dengan <br> agar tampil di HTML
            messageElement.innerHTML = message.replace(/\n/g, '<br>');
            chatbox.appendChild(messageElement);
            // Auto-scroll ke bawah
            chatbox.scrollTop = chatbox.scrollHeight;
        }

        // Event listener untuk form submission
        chatForm.addEventListener('submit', async function(event) {
            event.preventDefault(); // Mencegah reload halaman

            const userMessage = messageInput.value.trim();
            if (!userMessage) return; // Jangan kirim jika kosong

            // 1. Tampilkan pesan pengguna
            addMessage(userMessage, 'user');
            messageInput.value = ''; // Kosongkan input
            sendButton.disabled = true; // Nonaktifkan tombol kirim
            loadingIndicator.style.display = 'block'; // Tampilkan loading
            errorMessageDiv.textContent = ''; // Bersihkan pesan error sebelumnya

            try {
                // 2. Kirim pesan ke backend Laravel
                const response = await fetch("{{ route('chat.send') }}", { // Gunakan route name
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-CSRF-TOKEN': csrfToken // Sertakan CSRF token
                    },
                    body: JSON.stringify({ message: userMessage })
                });

                const data = await response.json();

                // 3. Tampilkan respons dari backend (Gemini)
                if (response.ok) {
                    addMessage(data.reply, 'bot');
                } else {
                    // Tampilkan pesan error dari server jika ada
                    const errorText = data.error || `Gagal mendapatkan respons (Status: ${response.status})`;
                    addMessage(`Error: ${errorText}`, 'bot'); // Tampilkan error di chatbox
                    errorMessageDiv.textContent = `Error: ${errorText}`; // Tampilkan juga di bawah form
                    console.error('Server Error:', data);
                }

            } catch (error) {
                // Tangani error network atau JavaScript
                const errorText = 'Tidak dapat terhubung ke server.';
                addMessage(`Error: ${errorText}`, 'bot'); // Tampilkan error di chatbox
                errorMessageDiv.textContent = `Error: ${errorText}`;
                console.error('Fetch Error:', error);
            } finally {
                // Apapun hasilnya, aktifkan kembali tombol dan sembunyikan loading
                sendButton.disabled = false;
                loadingIndicator.style.display = 'none';
                messageInput.focus(); // Fokuskan kembali ke input
            }
        });

         // Tambahkan pesan bot awal saat halaman dimuat
         // addMessage("Halo! Ada yang bisa saya bantu?", 'bot'); // Pindahkan ke HTML awal saja

    </script>

</body>
</html>