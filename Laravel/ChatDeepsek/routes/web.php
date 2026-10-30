<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\DeepSeekController;
use App\Http\Controllers\ChatController;

Route::get('/', function () {
    return view('welcome');
});

Route::post('/deepseek/chat', [DeepSeekController::class, 'chat']);

Route::get('/deepseek/chat-test', function(){
    return app()->make(App\Http\Controllers\DeepSeekController::class)->chat(
        new \Illuminate\Http\Request([
            'messages' => [['role' => 'user', 'content' => 'Hai']]
        ])
        );
});

Route::get('/chat', [ChatController::class, 'index'])->name('chat.index');
Route::post('/chat/send', [ChatController::class, 'sendMessage'])->name('chat.send');