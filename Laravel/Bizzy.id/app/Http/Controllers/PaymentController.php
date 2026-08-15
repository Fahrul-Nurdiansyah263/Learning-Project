<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Midtrans\Snap;

class PaymentController extends Controller
{
    public function createTransaction(Request $request)
    {
        $orderId = 'order-' . time();
        $grossAmount = 10000; // Contoh jumlah pembayaran

        $params = [
            'transaction_details' => [
                'order_id' => $orderId,
                'gross_amount' => $grossAmount,
            ],
            'customer_details' => [
                'first_name' => 'Budi',
                'last_name' => 'Prasetyo',
                'email' => 'budi.prasetyo@example.com',
                'phone' => '081234567890',
            ],
        ];

        try {
            $snapToken = Snap::getSnapToken($params);
            return view('payment', ['snap_token' => $snapToken]);
        } catch (\Exception $e) {
            return $e->getMessage();
        }
    }
}