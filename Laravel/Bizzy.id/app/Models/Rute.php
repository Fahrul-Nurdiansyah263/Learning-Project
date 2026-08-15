<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;

class Rute extends Model
{
    use HasFactory, SoftDeletes;
    protected $table = 'rute';
    public $timestamps = false;
    protected $fillable = ['terminal_keberangkatan_id', 'terminal_tujuan_id', 'estimasi_durasi_menit'];

    public function terminalKeberangkatan()
    {
        return $this->belongsTo(Terminal::class, 'terminal_keberangkatan_id');
    }

    public function terminalTujuan()
    {
        return $this->belongsTo(Terminal::class, 'terminal_tujuan_id');
    }
}
