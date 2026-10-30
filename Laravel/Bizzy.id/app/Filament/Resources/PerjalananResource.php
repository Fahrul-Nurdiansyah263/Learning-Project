<?php

namespace App\Filament\Resources;

use App\Filament\Resources\PerjalananResource\Pages;
use App\Models\Perjalanan;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;
use App\Enum\StatusPerjalananEnum;

class PerjalananResource extends Resource
{
    protected static ?string $model = Perjalanan::class;
    protected static ?string $pluralModelLabel = 'Pemesanan';
    protected static ?string $navigationLabel = 'Pemesanan';
    protected static ?string $navigationIcon = 'heroicon-o-globe-alt';
    protected static ?string $navigationGroup = 'Manajemen Perjalanan';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\Select::make('rute_id')
                    ->relationship('rute', 'id')
                    ->getOptionLabelFromRecordUsing(fn ($record) => "{$record->terminalKeberangkatan->kota} → {$record->terminalTujuan->kota}")
                    ->searchable()
                    ->required(),

                Forms\Components\Select::make('bus_id')
                    ->relationship('bus', 'nama')
                    ->searchable()
                    ->required(),

                Forms\Components\DateTimePicker::make('waktu_berangkat')
                    ->required(),

                Forms\Components\DateTimePicker::make('waktu_tiba')
                    ->required(),

                Forms\Components\TextInput::make('harga')
                    ->numeric()
                    ->prefix('Rp')
                    ->required(),

                Forms\Components\Select::make('status')
                    ->options(StatusPerjalananEnum::class)
                    ->required(),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('rute.terminalKeberangkatan.kota')
                    ->label('Dari')
                    ->sortable()
                    ->searchable(),

                Tables\Columns\TextColumn::make('rute.terminalTujuan.kota')
                    ->label('Ke')
                    ->sortable()
                    ->searchable(),

                Tables\Columns\TextColumn::make('bus.nama')->sortable(),

                Tables\Columns\TextColumn::make('waktu_berangkat')
                    ->dateTime('d M Y, H:i')
                    ->sortable(),

                Tables\Columns\TextColumn::make('harga')->money('IDR'),

                Tables\Columns\TextColumn::make('status')->badge(),
            ])
            ->filters([
                //
            ])
            ->actions([
                Tables\Actions\EditAction::make(),
                Tables\Actions\DeleteAction::make(),
            ])
            ->bulkActions([
                Tables\Actions\BulkActionGroup::make([
                    Tables\Actions\DeleteBulkAction::make(),
                ]),
            ]);
    }

    public static function getPages(): array
    {
        return [
            'index' => Pages\ListPerjalanans::route('/'),
            'create' => Pages\CreatePerjalanan::route('/create'),
            'edit' => Pages\EditPerjalanan::route('/{record}/edit'),
        ];
    }
}