<!-- I have not failed. I've just found 10,000 ways that won't work. - Thomas Edison -->
<!-- resources/views/components/layouts/app.blade.php -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aplikasi Tiket Bus</title>
    @vite('resources/css/app.css')
    @livewireStyles
</head>
<body class="bg-gray-100">

    {{ $slot }} <!-- Tempat di mana konten halaman Livewire akan ditampilkan -->

    @livewireScripts
    @stack('scripts')
</body>
</html>
