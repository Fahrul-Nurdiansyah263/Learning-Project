<?php

namespace App\Models;
use App\Enum\StatusTiketEnum;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Tiket extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'tiket';
    public $timestamps = false;
    protected $fillable = [
        'pemesanan_id', 'perjalanan_id', 'nama_penumpang', 
        'email_penumpang', 'nomor_kursi', 'kode_tiket', 'status'
    ];

    protected $casts = [
        'status' => StatusTiketEnum::class,
    ];

    public function pemesanan()
    {
        return $this->belongsTo(Pemesanan::class);
    }

    public function perjalanan()
    {
        return $this->belongsTo(Perjalanan::class);
    }
}
