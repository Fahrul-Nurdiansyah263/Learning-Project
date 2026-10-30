<?php

namespace App\Models;
use App\Enum\StatusPerjalananEnum;


use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Perjalanan extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'perjalanan';
    protected $fillable = ['rute_id', 'bus_id', 'waktu_berangkat', 'waktu_tiba', 'harga', 'status'];

    protected $casts = [
        'waktu_berangkat' => 'datetime',
        'waktu_tiba' => 'datetime',
        'harga' => 'decimal:2',
        'status' => StatusPerjalananEnum::class, 
    ];

    public function rute()
    {
        return $this->belongsTo(Rute::class);
    }

    public function bus()
    {
        return $this->belongsTo(Bus::class);
    }
}
