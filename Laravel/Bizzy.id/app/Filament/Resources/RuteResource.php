<?php

namespace App\Filament\Resources;

use App\Filament\Resources\RuteResource\Pages;
use App\Models\Rute;
use Filament\Forms;
use Filament\Forms\Form;
use Filament\Resources\Resource;
use Filament\Tables;
use Filament\Tables\Table;

class RuteResource extends Resource
{
    protected static ?string $model = Rute::class;

    protected static ?string $navigationIcon = 'heroicon-o-map'; 

    protected static ?string $pluralModelLabel = 'Rute';
    protected static ?string $navigationLabel = 'Rute';

    protected static ?string $navigationGroup = 'Manajemen Transportasi';

    public static function form(Form $form): Form
    {
        return $form
            ->schema([
                Forms\Components\Select::make('terminal_keberangkatan_id')
                    ->relationship('terminalKeberangkatan', 'nama')
                    ->searchable()
                    ->required(),
                Forms\Components\Select::make('terminal_tujuan_id')
                    ->relationship('terminalTujuan', 'nama')
                    ->searchable()
                    ->required(),
                Forms\Components\TextInput::make('estimasi_durasi_menit')->numeric(),
            ]);
    }

    public static function table(Table $table): Table
    {
        return $table
            ->columns([
                Tables\Columns\TextColumn::make('terminalKeberangkatan.nama')
                    ->label('Dari')
                    ->searchable()
                    ->sortable(),
                Tables\Columns\TextColumn::make('terminalTujuan.nama')
                    ->label('Ke')
                    ->searchable()
                    ->sortable(),
                // DIPERBAIKI: Typo pada nama kolom
                Tables\Columns\TextColumn::make('estimasi_durasi_menit')
                    ->label('Durasi (Menit)')
                    ->sortable(),
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
            'index' => Pages\ListRutes::route('/'),
            'create' => Pages\CreateRute::route('/create'),
            'edit' => Pages\EditRute::route('/{record}/edit'),
        ];
    }
}