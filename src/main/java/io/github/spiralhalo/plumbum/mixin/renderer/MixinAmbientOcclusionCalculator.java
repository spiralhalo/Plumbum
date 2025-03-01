/*
 * Copyright (c) 2016-2022 Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.spiralhalo.plumbum.mixin.renderer;

import java.util.BitSet;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

import io.github.spiralhalo.plumbum.renderer.accessor.AccessAmbientOcclusionCalculator;

@Mixin(targets = "net.minecraft.client.render.block.BlockModelRenderer$AmbientOcclusionCalculator")
public abstract class MixinAmbientOcclusionCalculator implements AccessAmbientOcclusionCalculator {
	@Final
	@Shadow
	float[] brightness;

	@Final
	@Shadow
	int[] light;

	@Shadow
	public abstract void apply(BlockRenderView blockRenderView, BlockState blockState, BlockPos pos, Direction face, float[] aoData, BitSet controlBits, boolean shade);

	@Override
	public float[] plumbum_colorMultiplier() {
		return brightness;
	}

	@Override
	public int[] plumbum_brightness() {
		return light;
	}

	@Override
	public void plumbum_apply(BlockRenderView blockRenderView, BlockState blockState, BlockPos pos, Direction face, float[] aoData, BitSet controlBits, boolean shade) {
		apply(blockRenderView, blockState, pos, face, aoData, controlBits, shade);
	}
}
