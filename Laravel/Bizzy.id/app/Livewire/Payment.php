<?php

namespace App\Livewire;

use Livewire\Component;
use App\Models\Order;
use Illuminate\Support\Str;
use Midtrans\Config;
use Midtrans\Snap;

class Payment extends Component
{
    // Properti untuk form
    public $name;
    public $email;
    public $phone;
    public $address;

    // Contoh, total yang harus dibayar. Bisa didapat dari keranjang belanja.
    public $totalAmount = 150000;

    public function render()
    {
        return view('livewire.payment');
    }

    public function checkout()
    {
        // 1. Validasi data input
        $this->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email',
            'phone' => 'required|string|max:15',
            'address' => 'required|string',
        ]);

        // 2. Konfigurasi Midtrans
        Config::$serverKey = config('services.midtrans.server_key');
        Config::$isProduction = config('services.midtrans.is_production');
        Config::$isSanitized = true;
        Config::$is3ds = true;

        // 3. Buat pesanan di database
        $orderId = 'ORDER-' . strtoupper(Str::random(10));
        $order = Order::create([
            'order_id' => $orderId,
            'name' => $this->name,
            'email' => $this->email,
            'phone' => $this->phone,
            'address' => $this->address,
            'total_amount' => $this->totalAmount,
            'status' => 'pending',
        ]);

        // 4. Siapkan parameter untuk Midtrans
        $params = [
            'transaction_details' => [
                'order_id' => $order->order_id,
                'gross_amount' => $order->total_amount,
            ],
            'customer_details' => [
                'first_name' => $this->name,
                'email' => $this->email,
                'phone' => $this->phone,
                'billing_address' => [
                    'address' => $this->address
                ]
            ],
        ];

        // 5. Dapatkan Snap Token
        $snapToken = Snap::getSnapToken($params);

        // Simpan snap token ke pesanan & kirim ke frontend
        $order->update(['snap_token' => $snapToken]);
        $this->dispatch('snap-show', token: $snapToken);
    }
}