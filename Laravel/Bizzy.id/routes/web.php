<?php

use Illuminate\Support\Facades\Route;
use App\Livewire\ShowPerjalanan;

Route::get('/', function () {
    return view('welcome');
});

use App\Http\Controllers\PaymentController;

Route::get('/payment', [PaymentController::class, 'createTransaction']);
Route::get('/cek-status', [PaymentController::class, 'checkStatus'])->name('payment.status');

Route::get('/pay', function () {
    return view('paymentPage');
});

Route::get('/perjalanan', ShowPerjalanan::class);