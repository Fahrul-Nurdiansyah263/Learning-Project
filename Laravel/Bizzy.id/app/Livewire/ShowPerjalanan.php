<?php

namespace App\Livewire;

use Livewire\Component;
use App\Models\Perjalanan;
use App\Models\Pemesanan;
use Midtrans\Config;
use Midtrans\Snap;
use App\Enum\StatusPerjalananEnum;
use App\Enum\StatusPembayaranEnum;

class ShowPerjalanan extends Component
{
    public $perjalananTersedia;

    public function mount()
    {
        config::$serverKey = env('MIDTRANS_SERVER_KEY');
        config::$isProduction = env('MIDTRANS_IS_PRODUCTION');

        $this->perjalananTersedia = Perjalanan::with(['rute.terminalKeberangkatan', 'rute.terminalTujuan', 'bus'])
            ->where('status', StatusPerjalananEnum::Tersedia)
            ->latest('waktu_berangkat')
            ->get();
    }

    public function startPayment($perjalananId)
    {
        $perjalanan = Perjalanan::findOrFail($perjalananId);

        $pemesanan = Pemesanan::create([
            'kode_pemesanan' => 'TICKET-'. uniqid(),
            'jumlah_total' => $perjalanan->harga,
            'status_pembayaran' => StatusPembayaranEnum::MenungguPembayaran,
        ]);

        $params = [
            'transaction_details' => [
                'order_id' => $pemesanan->kode_pemesanan,
                'gross_amount' => $pemesanan->jumlah_total,
            ],
        ];

        $snapToken = Snap::getSnapToken($params);
        $this->dispatch('snap-pay', token: $snapToken);

    }

    public function render()
    {
        return view('livewire.show-perjalanan')->layout('layouts.app');
    }
}
