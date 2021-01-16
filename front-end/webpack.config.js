module.exports = {
    module: {
        rules: [
            {
                test: /\.png$/,
                use: 'file-loader',
            },
            {
                test: /\.css$/,
                use: [
                    'style-loader',
                    {loader: 'css-loader', options: {modules: true, importLoaders: 1}},
                    {
                        loader: 'postcss-loader',
                        options: {
                            plugins: [
                                require('cssnano')({ preset: ['default', { normalizeUrl: false }] }), //If this line is removed, there will be no errors.
                            ],
                        },
                    }
                ],
            },
        ],
    },
}