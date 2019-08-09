# 0.0.0.3
* Port to 1.14.4
* Various changes

# 0.0.0.2g
* Fixed a comment in the Shallow Frozen Ocean class causing "errors" in some IDEs.
* Fixed a bug in ExpansiveWorldType that caused all dimensions to generate chunks according to the Expansive Biomes chunk generator. (closes #1)
* Further tweaks on mathematical operations performed on values extracted from noise maps. Expect even more tweaking on this in the future!

# 0.0.0.2f
* Added custom Shallow Ocean biomes for each temperature type.
* Minor worldgen tweaks.

# 0.0.0.2e
* Added vanilla Deep Oceans into worldgen for each temperature type.
* Minor worldgen tweaks.

# 0.0.0.2d
* Main world generation now uses a Perlin noise map instead of Simplex.
* Derived seeds for the Simplex temperature noise map can now be negative if the original seed is negative.

# 0.0.0.2c
* Real fix for inverted land temperatures
* Warm oceans actually generate now

# 0.0.0.2b
* Added the following vanilla biomes to worldgen: Forest, Cold Taiga, Desert, Savannah (Jungle, Tundra, don't seem to generate yet).
* Land generation now bound to temperature similar to Oceans.

# 0.0.0.2a
* Improved Ocean temperature diversity significantly.
* Temperature noise map is now generated from a value derived from the world seed, allowing greater variation.
* Further tweaks to worldgen

# 0.0.0.2
* Updated Ginkgo leaf texture
* Updated Maple planks texture
* Fixed a bug that prevented COLD_OCEAN from generating (missing array entry).
* Ocean temps have been updated to encourage a wider diversity of ocean types.
* Tweaked d-value (varies with depth from SimplexNoiseGenerator) to provide larger oceans (~85.2% of map?).
* Made maps more noisy to encourage wilder, less ovoid terrain.

# 0.0.0.1
* Initial Github release. PRE-ALPHA!
