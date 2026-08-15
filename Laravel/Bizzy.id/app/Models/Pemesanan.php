<?php

namespace App\Models;
use App\Enum\StatusPembayaranEnum;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Pemesanan extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'pemesanan';
    protected $fillable = [
        'pengguna_id', 'kode_pemesanan', 'jumlah_total', 'status_pembayaran', 
        'metode_pembayaran', 'waktu_pembayaran'
    ];

    protected $casts = [
        'jumlah_total' => 'decimal:2',
        'status_pembayaran' => StatusPembayaranEnum::class,
        'waktu_pembayaran' => 'datetime',
    ];

    public function tiket()
    {
        return $this->hasMany(Tiket::class);
    }

}
